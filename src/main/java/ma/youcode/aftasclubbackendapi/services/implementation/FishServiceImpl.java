package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.FishDto;
import ma.youcode.aftasclubbackendapi.dto.requests.FishRequest;
import ma.youcode.aftasclubbackendapi.entities.Fish;
import ma.youcode.aftasclubbackendapi.exceptions.AlreadyExistExceptions.FishAlreadyExistException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.FishNotFoundException;
import ma.youcode.aftasclubbackendapi.repositories.FishRepository;
import ma.youcode.aftasclubbackendapi.services.FishService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;
    private final ModelMapper mapper;

    @Override
    public List<FishDto> getAll() {
        List<Fish> fishList = fishRepository.findAll();
        if (fishList.isEmpty())
            throw new FishNotFoundException("No Fish Found");
        return fishList.stream().map(fish -> mapper.map(fish, FishDto.class)).toList();
    }

    @Override
    public Page<FishDto> getAll(Pageable pageable) {
        Page<Fish> fishPage = fishRepository.findAll(pageable);
        if (fishPage.isEmpty())
            throw new FishNotFoundException("No Fish Found");
        return fishPage.map(fish -> mapper.map(fish, FishDto.class));
    }

    @Override
    public Optional<FishDto> find(String s) {
        Optional<Fish> fish = fishRepository.findById(s);
        if (fish.isEmpty())
            throw new FishNotFoundException("Fish Not Found With Name: " + s);
        return Optional.of(mapper.map(fish, FishDto.class));
    }

    @Override
    public Optional<FishDto> create(FishRequest fishRequest) {
        if (fishRepository.findById(fishRequest.getName()).isPresent())
            throw new FishAlreadyExistException("Fish already Exist with Name: " + fishRequest.getName());
        else {
            Fish fish = mapper.map(fishRequest, Fish.class);
            Fish savedFish = fishRepository.save(fish);
            return Optional.of(mapper.map(savedFish, FishDto.class));
        }
    }

    @Override
    public Optional<FishDto> update(FishRequest fishRequest, String name) {
        if (fishRepository.findById(name).isEmpty())
            throw new FishNotFoundException("Fish Not Found With Name: " + name);
        else {
            Fish fish = mapper.map(fishRequest, Fish.class);
            Fish savedFish = fishRepository.save(fish);
            return Optional.of(mapper.map(savedFish, FishDto.class));
        }
    }

    @Override
    public boolean destroy(String name) {
        Optional<Fish> fish = fishRepository.findById(name);
        if (fish.isPresent()){
            fishRepository.delete(fish.get());
            return true;
        }else throw new FishNotFoundException("Fish Not Found With Name: " + name);
    }
}

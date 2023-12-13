package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.LevelDto;
import ma.youcode.aftasclubbackendapi.dto.requests.LevelRequest;
import ma.youcode.aftasclubbackendapi.entities.Level;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.LevelNotFoundException;
import ma.youcode.aftasclubbackendapi.repositories.LevelRepository;
import ma.youcode.aftasclubbackendapi.services.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final ModelMapper mapper;
    @Override
    public List<LevelDto> getAll() {
        List<Level> levels = levelRepository.findAll();
        if (levels.isEmpty())
            throw new LevelNotFoundException("No Levels Found");
        return levels.stream().map(level -> mapper.map(level, LevelDto.class)).toList();
    }

    @Override
    public Page<LevelDto> getAll(Pageable pageable) {
        Page<Level> levels = levelRepository.findAll(pageable);
        if (levels.isEmpty())
            throw new LevelNotFoundException("No Levels Found");
        return levels.map(level -> mapper.map(level, LevelDto.class));
    }

    @Override
    public Optional<LevelDto> find(Integer code) {
        Optional<Level> level = levelRepository.findById(code);
        if (level.isEmpty())
            throw new LevelNotFoundException("Level Not Found with Code: " + code);
        return Optional.of(mapper.map(level, LevelDto.class));
    }

    @Override
    public Optional<LevelDto> create(LevelRequest levelRequest) {
        Level level = mapper.map(levelRequest, Level.class);
        Level savedLevel = levelRepository.save(level);
        return Optional.of(mapper.map(savedLevel, LevelDto.class));
    }

    @Override
    public Optional<LevelDto> update(LevelRequest levelRequest, Integer code) {
        Optional<Level> levelFound = levelRepository.findById(code);
        if (levelFound.isEmpty())
            throw new LevelNotFoundException("Level Not Found With Code: " + code);
        else {
            Level level = levelFound.get();
            level.setCode(level.getCode());
            level.setDescription(levelRequest.getDescription());
            level.setPoints(levelRequest.getPoints());
            Level updatedLevel = levelRepository.save(level);
            return Optional.of(mapper.map(updatedLevel, LevelDto.class));
        }
    }

    @Override
    public boolean destroy(Integer code) {
        Optional<Level> levelToDelete = levelRepository.findById(code);
        if (levelToDelete.isPresent()) {
            levelRepository.delete(levelToDelete.get());
            return true;
        } else throw new LevelNotFoundException("Level Not Found With Code: " + code);
    }
}

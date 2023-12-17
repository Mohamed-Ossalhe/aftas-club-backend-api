package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.RankingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.RankingRequest;
import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.entities.Member;
import ma.youcode.aftasclubbackendapi.entities.Ranking;
import ma.youcode.aftasclubbackendapi.entities.embedded.RankId;
import ma.youcode.aftasclubbackendapi.exceptions.AlreadyExistExceptions.MemberAlreadyExistException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.CompetitionNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.MemberNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.RankingNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions.MaxLimitsExceedException;
import ma.youcode.aftasclubbackendapi.repositories.CompetitionRepository;
import ma.youcode.aftasclubbackendapi.repositories.MemberRepository;
import ma.youcode.aftasclubbackendapi.repositories.RankingRepository;
import ma.youcode.aftasclubbackendapi.services.RankingService;
import ma.youcode.aftasclubbackendapi.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper mapper;

    /**
     * get all resources
     * @return {@link List}<{@link RankingDto}>
     */
    @Override
    public List<RankingDto> getAll() {
        List<Ranking> rankings = rankingRepository.findAll();
        if (rankings.isEmpty())
            throw new RankingNotFoundException("No Rankings Found");
        return rankings.stream().map(ranking -> mapper.map(ranking, RankingDto.class)).toList();
    }

    /**
     * get all resources paginated
     * @param pageable {@link Pageable}
     * @return {@link Page}<{@link RankingDto}>
     */
    @Override
    public Page<RankingDto> getAll(Pageable pageable) {
        Page<Ranking> rankingPage = rankingRepository.findAll(pageable);
        if (rankingPage.isEmpty())
            throw new RankingNotFoundException("No Rankings Found");
        return rankingPage.map(ranking -> mapper.map(ranking, RankingDto.class));
    }

    /**
     * get a specific resource
     * @param rankId instance of {@link RankId}
     * @return {@link Optional}<{@link RankingDto}>
     */
    @Override
    public Optional<RankingDto> find(RankId rankId) {
        Optional<Ranking> ranking = rankingRepository.findById(rankId);
        if (ranking.isEmpty())
            throw new RankingNotFoundException("Ranking not Found with Rank Id: " + rankId);
        return Optional.of(mapper.map(ranking, RankingDto.class));
    }

    /**
     * create & save a new resource
     * @param rankingRequest instance of {@link RankingRequest}
     * @return {@link Optional}<{@link RankingDto}>
     */
    @Override
    public Optional<RankingDto> create(RankingRequest rankingRequest) {
        Member member = memberRepository.findById(rankingRequest.getMember().getNum())
                .orElseThrow(() -> new MemberNotFoundException("Member not Found with Id: " + rankingRequest.getMember().getNum()));
        Competition competition = competitionRepository.findById(rankingRequest.getCompetition().getCode())
                .orElseThrow(() -> new CompetitionNotFoundException("Competition not Found with code: " + rankingRequest.getCompetition().getCode()));
        RankId rankId = new RankId(competition.getCode(), member.getNum());
        if (rankingRepository.findById(rankId).isPresent()) throw new MemberAlreadyExistException("Member already exist in the competition");
        Long days = Utils.calculateDaysUntilCompetition(competition.getDate());
        if (competition.getRanking().size() == competition.getNumberOfParticipants())
            throw new MaxLimitsExceedException("Can't add More Members Competition is Already Full.");
        Ranking ranking = new Ranking(rankId, rankingRequest.getRank(), rankingRequest.getScore(), member, competition);
        Ranking savedRanking = rankingRepository.save(ranking);
        return Optional.of(mapper.map(savedRanking, RankingDto.class));
    }

    /**
     * update a specific resource
     * @param rankingRequest instance of {@link RankingRequest}
     * @param rankId instance of {@link RankId}
     * @return {@link Optional}<{@link RankingDto}>
     */
    @Override
    public Optional<RankingDto> update(RankingRequest rankingRequest, RankId rankId) {
        return Optional.empty();
    }

    /**
     * deletes a specific resource
     * @param rankId instance of {@link RankId}
     * @return {@link Boolean}
     */
    @Override
    public boolean destroy(RankId rankId) {
        Optional<Ranking> ranking = rankingRepository.findById(rankId);
        if (ranking.isPresent()) {
            rankingRepository.delete(ranking.get());
            return true;
        }else throw new RankingNotFoundException("Ranking not Found with Rank Id: " + rankId);
    }
}

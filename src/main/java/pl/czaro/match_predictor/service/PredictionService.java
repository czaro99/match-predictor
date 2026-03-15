package pl.czaro.match_predictor.service;

import org.springframework.stereotype.Service;
import pl.czaro.match_predictor.model.Prediction;
import pl.czaro.match_predictor.repository.PredictionRepository;

import java.util.List;

@Service
public class PredictionService {

    private final PredictionRepository predictionRepository;

    public PredictionService(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    public List<Prediction> getAllPredictions() {
        return predictionRepository.findAll();
    }
}

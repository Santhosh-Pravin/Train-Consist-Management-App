package service;

import model.Train;

/**
 * Service class handling operations related to Train consists.
 */
public class TrainService {

    private Train train;

    public TrainService() {
        this.train = new Train();
    }

    public int getInitialBogieCount() {
        return train.getBogies().size();
    }
}

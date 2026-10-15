class RevisitedPositionException extends RuntimeException {
    private final int steps;

    RevisitedPositionException(int steps) {
        this.steps = steps;
    }

    int getSteps() {
        return steps;
    }
}
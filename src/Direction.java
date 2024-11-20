public enum Direction {
    NORTH(2), SOUTH(0), EAST(3), WEST(1);
    public final int frameLineNumber;

    /**
     *Permet de faire le lien entre la direction du sprite ainsi que la ligne de son fichier d'animation
     * @param frameLineNumber
     */
    Direction(int frameLineNumber) {
        this.frameLineNumber = frameLineNumber;
    }

    public int getFrameLineNumber() {
        return frameLineNumber;
    }
}

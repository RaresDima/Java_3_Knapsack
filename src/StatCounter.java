public class StatCounter {
    private long startTime;
    private long stopTime;
    private long time;
    private long totalMemory;
    private long freeMemory;
    private long usedMemory;

    StatCounter(){}

    /**
     * Starts counting the time the code after this method takes to execute
     */
    public void start() {
        startTime = System.nanoTime();
    }

    /**
     * Stops counting the time(called after start) and calculates the time elapsed and total, free and used memory
     */
    public void stop() {
        stopTime = System.nanoTime();
        time = stopTime - startTime;

        totalMemory = Runtime.getRuntime().totalMemory();
        freeMemory = Runtime.getRuntime().freeMemory();
        usedMemory = totalMemory - freeMemory;
    }

    /**
     * Returns the current stats as a parsed String for display
     * @return
     */
    public String toString() {
        StringBuilder buff = new StringBuilder("");

        StringBuilder time        = new StringBuilder(Double.toString(((this.time) / 10000) / 100.0));
        StringBuilder totalMemory = new StringBuilder(Double.toString(this.totalMemory/1024/1024.0));
        StringBuilder freeMemory  = new StringBuilder(Double.toString(this.freeMemory/1024/1024.0));
        StringBuilder usedMemory  = new StringBuilder(Double.toString(this.usedMemory/1024/1024.0));
        totalMemory.setLength(totalMemory.indexOf(".") + 3 + 1);
        freeMemory.setLength(freeMemory.indexOf(".") + 3 + 1);
        usedMemory.setLength(usedMemory.indexOf(".") + 3 + 1);


        if (time.length() - time.indexOf(".") == 3) time.append("0");
        if (time.length() - time.indexOf(".") == 2) time.append("00");

        if (totalMemory.length() - totalMemory.indexOf(".") == 3) totalMemory.append("0");
        if (totalMemory.length() - totalMemory.indexOf(".") == 2) totalMemory.append("00");
        if (totalMemory.length() - totalMemory.indexOf(".") == 4) {
            totalMemory.setCharAt(totalMemory.indexOf(".") + 2, '0');
            totalMemory.setCharAt(totalMemory.indexOf(".") + 3, '0');}

        if (freeMemory.length() - freeMemory.indexOf(".") == 3) freeMemory.append("0");
        if (freeMemory.length() - freeMemory.indexOf(".") == 2) freeMemory.append("00");

        if (usedMemory.length() - usedMemory.indexOf(".") == 3) usedMemory.append("0");
        if (usedMemory.length() - usedMemory.indexOf(".") == 2) usedMemory.append("00");


        totalMemory.insert(totalMemory.indexOf("."), " ");
        totalMemory.insert(totalMemory.indexOf(".") + 1, " ");
        freeMemory.insert(freeMemory.indexOf("."), " ");
        freeMemory.insert(freeMemory.indexOf(".") + 1, " ");
        usedMemory.insert(usedMemory.indexOf("."), " ");
        usedMemory.insert(usedMemory.indexOf(".") + 1, " ");
        time.insert(time.indexOf("."), " ");
        time.insert(time.indexOf(".") + 1, " ");


        if ((Double)(this.totalMemory/1024/1024.0) < 100)
            buff.append("Total memory:\t " + totalMemory + "\tMB\n");
        else
            buff.append("Total memory:\t" + totalMemory + "\tMB\n");

        if ((Double)(this.freeMemory/1024/1024.0) < 100)
            buff.append("Free memory:\t " + freeMemory + "\tMB\n");
        else
            buff.append("Free memory:\t" + freeMemory + "\tMB\n");

        if ((Double)(this.usedMemory/1024/1024.0) < 100)
            buff.append("Used memory:\t " + usedMemory + "\tMB\n");
        else
            buff.append("Used memory:\t" + usedMemory + "\tMB\n");

        if ((Double)(((this.time) / 10000) / 100.0) < 100)
            buff.append("\nTime:\t\t\t " + time + "\tms");
        else
            buff.append("\nTime:\t\t\t" + time + "\tms");

        return new String(buff);
    }
}

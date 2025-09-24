package Ticket;

public class Receipt {
    private long entryTime;
    private long exitTime;

    public Receipt(long entryTime, long exitTime) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }
}
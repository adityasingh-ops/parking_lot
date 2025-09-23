package Slot;

public class SizeDecorator implements SlotDecorator {
    private String size;

    public SizeDecorator(String size) {
        this.size = size;
    }

    @Override
    public String getDescription() {
        return "Size: " + size;
    }

    public String getSize() {
        return size;
    }
}

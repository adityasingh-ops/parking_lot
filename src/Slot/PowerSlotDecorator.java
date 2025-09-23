package Slot;

public class PowerSlotDecorator implements SlotDecorator {
    @Override
    public String getDescription() {
        return "Powered";
    }

    public boolean isPowered() {
        return true;
    }
}

public enum EMPTYPES {
    INVALID,
    MANAGER,
    HOUSEKEEPING,
    MAINTENANCE,
    VALET,
    FOOD,
    CONCIERGE;

    public static EMPTYPES getEmpTypeByIndex(int index) {
        return EMPTYPES.values()[index]; // less safe
    }
}


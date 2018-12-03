/**
 * EMPTYPES specifies "what type of employee" a user can be.
 */
public enum EMPTYPES {
  INVALID,
  MANAGER,
  HOUSEKEEPING,
  MAINTENANCE,
  VALET,
  FOOD;

  public static EMPTYPES getEmpTypeByIndex(int index) {
        return EMPTYPES.values()[index]; // less safe
    }
}


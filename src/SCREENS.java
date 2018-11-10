public enum SCREENS {
  LOGIN(0),
  MANAGERHOME(1),
  CREATENEWGUEST(2),
  FLOORCHART(3),
  HOUSEKEEPING(4),
  MAINTENANCE(5),
  VALET(6),
  ALLREQUESTS(7),
  EMPLOYEELIST(8),
  GUESTHOME(9),
  MAINTENANCEREQUEST(10),
  HOUSEKEEPINGREQUEST(11),
  FOODSERVICE(12),
  CONCIERGE(13);

  private final int value;

  SCREENS(final int newValue){
    value = newValue;
  }

  public int getValue(){
    return value;
  }
}

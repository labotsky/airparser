package com.united.entity;

/**
 * @author Labotski_SV
 *
 */
public class AirLines {

  public enum EconomyClass {
    AWARDECON("Economy"),
    AWARDBUSINESSFIRST("Business/BusinessFirst"),
    AWARDFIRST("First/Global First");
    private String value;

    private EconomyClass(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

  }

  public enum Type {
    OW,
    RT;
  }

  private String startDate;

  private String endDate;

  private String origin;

  private String destination;

  private int seats;

  private EconomyClass classEconomy;

  private String request_id;

  private String user_id;

  private Type type;

  /**
   * @param builder
   */
  private AirLines(AirLinesBuilder builder) {
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.origin = builder.origin;
    this.destination = builder.destination;
    this.seats = builder.seats;
    this.classEconomy = builder.classEconomy;
    this.request_id = builder.request_id;
    this.user_id = builder.user_id;
    this.type = builder.type;
  }

  @Override
  public String toString() {
    return "UnitedParse [startDate=" + startDate + ", endDate=" + endDate + ", origin=" + origin + ", destination=" + destination + ", seats=" + seats
        + ", classEconomy=" + classEconomy + ", request_id=" + request_id + ", user_id=" + user_id + ", type=" + type + "]";
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public String getOrigin() {
    return origin;
  }

  public String getDestination() {
    return destination;
  }

  public int getSeats() {
    return seats;
  }

  public EconomyClass getClassEconomy() {
    return classEconomy;
  }

  public String getRequest_id() {
    return request_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public Type getType() {
    return type;
  }

  public static class AirLinesBuilder {
    private String startDate;

    private String endDate;

    private String origin;

    private String destination;

    private int seats;

    private EconomyClass classEconomy;

    private String request_id;

    private String user_id;

    private Type type;

    /**
     * @param startDate
     * @return
     */
    public AirLinesBuilder startDate(String startDate) {
      this.startDate = startDate;
      return this;
    }

    /**
     * @param endDate
     * @return
     */
    public AirLinesBuilder endDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    /**
     * @param origin
     * @return
     */
    public AirLinesBuilder origin(String origin) {
      this.origin = origin;
      return this;
    }

    /**
     * @param destination
     * @return
     */
    public AirLinesBuilder destination(String destination) {
      this.destination = destination;
      return this;
    }

    /**
     * @param seats
     * @return
     */
    public AirLinesBuilder seats(int seats) {
      this.seats = seats;
      return this;
    }

    /**
     * @param awardbusinessfirst
     * @return
     */
    public AirLinesBuilder classEconomy(EconomyClass awardbusinessfirst) {
      this.classEconomy = awardbusinessfirst;
      return this;
    }

    /**
     * @param request_id
     * @return
     */
    public AirLinesBuilder request_id(String request_id) {
      this.request_id = request_id;
      return this;
    }

    /**
     * @param user_id
     * @return
     */
    public AirLinesBuilder user_id(String user_id) {
      this.user_id = user_id;
      return this;
    }

    /**
     * @param type
     * @return
     */
    public AirLinesBuilder type(Type type) {
      this.type = type;
      return this;
    }

    /**
     * @return build UnitedParse
     */
    public AirLines build() {
      AirLines unitedParse = new AirLines(this);
      return unitedParse;
    }
  }
}

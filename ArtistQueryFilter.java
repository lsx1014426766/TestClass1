package entity;


public enum ArtistQueryFilter
{
  ArtistID("ArtistID"), 
  Name("Name"), 
  Gender("Gender"), 
  PinyinName("PinyinName"), 
  TranslateName("TranslateName"), 
  RegionCode("RegionCode"), 
  Attribute("Attribute"), 
  score("score");

  private String filterField;

  private ArtistQueryFilter(String filterField) {
    this.filterField = filterField;
  }

  public String getValue() {
    return this.filterField;
  }
}

package exp;

public class SolrQueryException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public SolrQueryException(String mes)
  {
    super(mes);
  }
}

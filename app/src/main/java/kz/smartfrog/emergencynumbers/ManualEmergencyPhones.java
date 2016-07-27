package kz.smartfrog.emergencynumbers;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class ManualEmergencyPhones
{
  private String objectId;
  private String nameOfCompanyKZ;
  private String nameOfCompanyENG;
  private String phoneNumber;
  private String ownerId;
  private String city;
  private String country;
  private java.util.Date created;
  private String nameOfCompanyRU;
  private java.util.Date updated;
  public String getObjectId()
  {
    return objectId;
  }

  public String getNameOfCompanyKZ()
  {
    return nameOfCompanyKZ;
  }

  public void setNameOfCompanyKZ( String nameOfCompanyKZ )
  {
    this.nameOfCompanyKZ = nameOfCompanyKZ;
  }

  public String getNameOfCompanyENG()
  {
    return nameOfCompanyENG;
  }

  public void setNameOfCompanyENG( String nameOfCompanyENG )
  {
    this.nameOfCompanyENG = nameOfCompanyENG;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber( String phoneNumber )
  {
    this.phoneNumber = phoneNumber;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity( String city )
  {
    this.city = city;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry( String country )
  {
    this.country = country;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getNameOfCompanyRU()
  {
    return nameOfCompanyRU;
  }

  public void setNameOfCompanyRU( String nameOfCompanyRU )
  {
    this.nameOfCompanyRU = nameOfCompanyRU;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public ManualEmergencyPhones save()
  {
    return Backendless.Data.of( ManualEmergencyPhones.class ).save( this );
  }

  public Future<ManualEmergencyPhones> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<ManualEmergencyPhones> future = new Future<ManualEmergencyPhones>();
      Backendless.Data.of( ManualEmergencyPhones.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<ManualEmergencyPhones> callback )
  {
    Backendless.Data.of( ManualEmergencyPhones.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( ManualEmergencyPhones.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( ManualEmergencyPhones.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( ManualEmergencyPhones.class ).remove( this, callback );
  }

  public static ManualEmergencyPhones findById( String id )
  {
    return Backendless.Data.of( ManualEmergencyPhones.class ).findById( id );
  }

  public static Future<ManualEmergencyPhones> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<ManualEmergencyPhones> future = new Future<ManualEmergencyPhones>();
      Backendless.Data.of( ManualEmergencyPhones.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<ManualEmergencyPhones> callback )
  {
    Backendless.Data.of( ManualEmergencyPhones.class ).findById( id, callback );
  }

  public static ManualEmergencyPhones findFirst()
  {
    return Backendless.Data.of( ManualEmergencyPhones.class ).findFirst();
  }

  public static Future<ManualEmergencyPhones> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<ManualEmergencyPhones> future = new Future<ManualEmergencyPhones>();
      Backendless.Data.of( ManualEmergencyPhones.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<ManualEmergencyPhones> callback )
  {
    Backendless.Data.of( ManualEmergencyPhones.class ).findFirst( callback );
  }

  public static ManualEmergencyPhones findLast()
  {
    return Backendless.Data.of( ManualEmergencyPhones.class ).findLast();
  }

  public static Future<ManualEmergencyPhones> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<ManualEmergencyPhones> future = new Future<ManualEmergencyPhones>();
      Backendless.Data.of( ManualEmergencyPhones.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<ManualEmergencyPhones> callback )
  {
    Backendless.Data.of( ManualEmergencyPhones.class ).findLast( callback );
  }

  public static BackendlessCollection<ManualEmergencyPhones> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( ManualEmergencyPhones.class ).find( query );
  }

  public static Future<BackendlessCollection<ManualEmergencyPhones>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<ManualEmergencyPhones>> future = new Future<BackendlessCollection<ManualEmergencyPhones>>();
      Backendless.Data.of( ManualEmergencyPhones.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<ManualEmergencyPhones>> callback )
  {
    Backendless.Data.of( ManualEmergencyPhones.class ).find( query, callback );
  }
}
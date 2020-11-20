package dm.v1;

import java.net.URI;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.apache.olingo.client.api.ODataClient;
import org.apache.olingo.client.api.communication.request.retrieve.EdmMetadataRequest;
import org.apache.olingo.client.api.communication.request.retrieve.ODataEntitySetIteratorRequest;
import org.apache.olingo.client.api.communication.response.ODataRetrieveResponse;
import org.apache.olingo.client.api.domain.ClientEntity;
import org.apache.olingo.client.api.domain.ClientEntitySet;
import org.apache.olingo.client.api.domain.ClientEntitySetIterator;
import org.apache.olingo.client.api.domain.ClientProperty;
import org.apache.olingo.client.api.domain.ClientValue;
import org.apache.olingo.client.core.ODataClientFactory;
import org.apache.olingo.commons.api.edm.Edm;
import org.apache.olingo.commons.api.edm.EdmComplexType;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmProperty;
import org.apache.olingo.commons.api.edm.EdmSchema;
import org.apache.olingo.commons.api.edm.FullQualifiedName;

public class Query {

    private static ODataClient client;
    public static ArrayList<Float> valuess = new ArrayList<>();

    public static int Query(String country, String year, String CauseOD) {
        valuess.clear();
        
        String serviceUrl = "https://ghoapi.azureedge.net/api/";
        client = ODataClientFactory.getClient();
        Edm edm = readEdm(serviceUrl);

        List<FullQualifiedName> ctFqns = new ArrayList<FullQualifiedName>();
        List<FullQualifiedName> etFqns = new ArrayList<FullQualifiedName>();
        for (EdmSchema schema : edm.getSchemas()) {
            for (EdmComplexType complexType : schema.getComplexTypes()) {
                ctFqns.add(complexType.getFullQualifiedName());
            }
            for (EdmEntityType entityType : schema.getEntityTypes()) {
                etFqns.add(entityType.getFullQualifiedName());
            }
        }
        print("Found ComplexTypes", ctFqns);
        print("Found EntityTypes", etFqns);

        print("\n----- Inspect each property and its type of the first entity: " + etFqns.get(0) + "----");
        EdmEntityType etype = edm.getEntityType(etFqns.get(0));
        for (String propertyName : etype.getPropertyNames()) {
            EdmProperty property = etype.getStructuralProperty(propertyName);
            FullQualifiedName typeName = property.getType().getFullQualifiedName();
            print("property '" + propertyName + "' " + typeName);
        }
        
       int YearX = 0;
       
          print("\n----- Read Entities ------------------------------");
        if(year == "PROJECTION2015"){
            YearX = 2016;
        }else{
         YearX = (Integer.parseInt(year) + 1);
        }
        
        

      
        ClientEntitySetIterator<ClientEntitySet, ClientEntity> iterator = readEntities(edm, serviceUrl,
                CauseOD + "?$filter=SpatialDim%20eq%20'" + country + "'%20and%20date(TimeDimensionBegin)%20ge%20" + year + "-01-01%20and%20date(TimeDimensionBegin)%20lt%20" + YearX + "-01-01"); // Change to be as needed
               
        while (iterator.hasNext()) {
            ClientEntity ce = iterator.next();
            print("Entry:\n" + prettyPrint(ce.getProperties(), 0));
            System.out.println(valuess);
        }
         float returnValue;
       
            if(valuess.size() == 0){
             returnValue = 0;
            }else if (valuess.size() > 1){
            returnValue = Inject.bubbleSort(valuess);
            }else{
            returnValue = valuess.get(0);
            }
      
        
            
     
     return (int) returnValue;
    }
     

    public static ClientEntitySetIterator<ClientEntitySet, ClientEntity> readEntities(Edm edm, String serviceUri,
            String entitySetName) {
        URI absoluteUri = client.newURIBuilder(serviceUri).appendEntitySetSegment(entitySetName).build();
        return readEntities(edm, absoluteUri);
    }

    public static Edm readEdm(String serviceUrl) {
        EdmMetadataRequest request = client.getRetrieveRequestFactory().getMetadataRequest(serviceUrl);
        ODataRetrieveResponse<Edm> response = request.execute();
        return response.getBody();
    }

    private static void print(String content) {
        System.out.println(content);
    }

    private static void print(String content, List<?> list) {
        System.out.println(content);
        for (Object o : list) {
            System.out.println("    " + o);
        }
        System.out.println();
    }

    private static ClientEntitySetIterator<ClientEntitySet, ClientEntity> readEntities(Edm edm, URI absoluteUri) {
        System.out.println("URI = " + absoluteUri);
        ODataEntitySetIteratorRequest<ClientEntitySet, ClientEntity> request
                = client.getRetrieveRequestFactory().getEntitySetIteratorRequest(absoluteUri);
        request.setAccept("application/json");
        ODataRetrieveResponse<ClientEntitySetIterator<ClientEntitySet, ClientEntity>> response = request.execute();

        return response.getBody();
    }

     private static String prettyPrint(Collection<ClientProperty> properties, int level) {
         StringBuilder b = new StringBuilder();

    for (ClientProperty entry : properties) {
      intend(b, level);
      ClientValue value = entry.getValue();
      
    if (value.isPrimitive()) {
        b.append(entry.getName()).append(": ");
        b.append(entry.getValue()).append("\n");
        if(entry.getName().equals("NumericValue")){
            try{
        valuess.add(Float.parseFloat(entry.getValue().toString()));
            }catch(Exception e){
                System.out.println("NumericValue is breaking it ?");
            }
        }
        
      }
     
    }
    return b.toString();
  }
    private static void intend(StringBuilder builder, int intendLevel) {
        for (int i = 0; i < intendLevel; i++) {
            builder.append("  ");
        }
    }
}

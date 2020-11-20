package dm.v1;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

public class RetrieveData {

    private static ODataClient client;

    public static ArrayList<String> CurrentArrayList = new ArrayList<>();

    public static ArrayList<String> RetrieveData(String SQLValue) {

        CurrentArrayList.removeAll(CurrentArrayList);

        String serviceUrl = "https://ghoapi.azureedge.net/api/";
        client = ODataClientFactory.getClient();
        Edm edm = readEdm(serviceUrl);

        List<FullQualifiedName> ctFqns = new ArrayList<>();
        List<FullQualifiedName> etFqns = new ArrayList<>();
        for (EdmSchema schema : edm.getSchemas()) {
            for (EdmComplexType complexType : schema.getComplexTypes()) {
                ctFqns.add(complexType.getFullQualifiedName());
            }
            for (EdmEntityType entityType : schema.getEntityTypes()) {
                etFqns.add(entityType.getFullQualifiedName());
            }
        }

        EdmEntityType entityType = edm.getEntityType(etFqns.get(0));

        for (String propertyName : entityType.getPropertyNames()) {

            EdmProperty property = entityType.getStructuralProperty(propertyName);
            FullQualifiedName typeName = property.getType().getFullQualifiedName();

            print("property '" + propertyName + "' " + typeName);
        }

        print("\n----- Read Entities ------------------------------");
        ClientEntitySetIterator<ClientEntitySet, ClientEntity> iterator = readEntities(edm, serviceUrl, SQLValue); // Change to be as needed

        while (iterator.hasNext()) {
            ClientEntity ce = iterator.next();
            CurrentArrayList.add(prettyPrint(ce.getProperties(), 0));
        }
        

        return CurrentArrayList;

    }

    private static String prettyPrint(Collection<ClientProperty> properties, int level) {

        StringBuilder b = new StringBuilder();

        for (ClientProperty entry : properties) {
            intend(b, level);
            ClientValue value = entry.getValue();

            if (entry.getName().equals("Title") || entry.getName().equals("Code") || entry.getName().equals("IndicatorName") || entry.getName().equals("IndicatorCode")) {

                if (value.isPrimitive()) {
                    b.append(entry.getValue());

                    if (entry.getName().equals("Code") || entry.getName().equals("IndicatorCode")) {
                        b.append("/");
                    }

                } else {
                    System.out.println("Not primitive type ");
                }
            }
        }
        return b.toString();
    }

    private static void intend(StringBuilder builder, int intendLevel) {
        for (int i = 0; i < intendLevel; i++) {
            builder.append("    ");
        }
    }

    public static ClientEntitySetIterator<ClientEntitySet, ClientEntity> readEntities(Edm edm, String serviceUri, String entitySetName) {
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
        ODataEntitySetIteratorRequest<ClientEntitySet, ClientEntity> request = client.getRetrieveRequestFactory().getEntitySetIteratorRequest(absoluteUri);
        request.setAccept("application/json");
        ODataRetrieveResponse<ClientEntitySetIterator<ClientEntitySet, ClientEntity>> response = request.execute();

        return response.getBody();
    }

}

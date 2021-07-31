# DefaultApi

All URIs are relative to *https://virtserver.swaggerhub.com/HakJko/StrudentsRest/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addGroup**](DefaultApi.md#addGroup) | **POST** /group | 
[**deleteGroup**](DefaultApi.md#deleteGroup) | **DELETE** /group/{groupId} | 
[**deleteStudent**](DefaultApi.md#deleteStudent) | **DELETE** /group/student/{studentId} | 
[**groupGet**](DefaultApi.md#groupGet) | **GET** /group | 
[**groupGroupIdGet**](DefaultApi.md#groupGroupIdGet) | **GET** /group/{groupId} | 
[**groupStudentGet**](DefaultApi.md#groupStudentGet) | **GET** /group/student | 
[**groupStudentPost**](DefaultApi.md#groupStudentPost) | **POST** /group/student | 
[**groupStudentStudentIdGet**](DefaultApi.md#groupStudentStudentIdGet) | **GET** /group/student/{studentId} | 
[**udateGroup**](DefaultApi.md#udateGroup) | **PUT** /group | 
[**udateStudent**](DefaultApi.md#udateStudent) | **PUT** /group/student | 

<a name="addGroup"></a>
# **addGroup**
> addGroup(body)



Create a new group

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
Group body = new Group(); // Group | 
try {
    apiInstance.addGroup(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Group**](Group.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/yaml
 - **Accept**: application/yaml

<a name="deleteGroup"></a>
# **deleteGroup**
> deleteGroup(groupId, apiKey)



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
String groupId = "groupId_example"; // String | Group id to delete
String apiKey = "apiKey_example"; // String | 
try {
    apiInstance.deleteGroup(groupId, apiKey);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| Group id to delete |
 **apiKey** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteStudent"></a>
# **deleteStudent**
> deleteStudent(studentId, apiKey)



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
String studentId = "studentId_example"; // String | Group id to delete
String apiKey = "apiKey_example"; // String | 
try {
    apiInstance.deleteStudent(studentId, apiKey);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteStudent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **String**| Group id to delete |
 **apiKey** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="groupGet"></a>
# **groupGet**
> List&lt;InlineResponse200&gt; groupGet(limit, offset)



Returns a list of group

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | Limits the number of items on a page
Integer offset = 56; // Integer | Specifies the page number of the groups to be displayed
try {
    List<InlineResponse200> result = apiInstance.groupGet(limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Limits the number of items on a page | [optional]
 **offset** | **Integer**| Specifies the page number of the groups to be displayed | [optional]

### Return type

[**List&lt;InlineResponse200&gt;**](InlineResponse200.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

<a name="groupGroupIdGet"></a>
# **groupGroupIdGet**
> InlineResponse200 groupGroupIdGet(groupId)



Obtain information about an goup from her unique groupId

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
String groupId = "groupId_example"; // String | 
try {
    InlineResponse200 result = apiInstance.groupGroupIdGet(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupGroupIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**|  |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

<a name="groupStudentGet"></a>
# **groupStudentGet**
> List&lt;Student&gt; groupStudentGet(limit, offset)



Returns a list of student

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | Limits the number of items on a page
Integer offset = 56; // Integer | Specifies the page number of the students to be displayed
try {
    List<Student> result = apiInstance.groupStudentGet(limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupStudentGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Limits the number of items on a page | [optional]
 **offset** | **Integer**| Specifies the page number of the students to be displayed | [optional]

### Return type

[**List&lt;Student&gt;**](Student.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

<a name="groupStudentPost"></a>
# **groupStudentPost**
> groupStudentPost(body)



Create a new student

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
Student body = new Student(); // Student | 
try {
    apiInstance.groupStudentPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupStudentPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Student**](Student.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/yaml
 - **Accept**: application/yaml

<a name="groupStudentStudentIdGet"></a>
# **groupStudentStudentIdGet**
> Student groupStudentStudentIdGet(studentId)



Obtain information about an student from his unique studentId

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
String studentId = "studentId_example"; // String | 
try {
    Student result = apiInstance.groupStudentStudentIdGet(studentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupStudentStudentIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **String**|  |

### Return type

[**Student**](Student.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

<a name="udateGroup"></a>
# **udateGroup**
> udateGroup(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
Group body = new Group(); // Group | 
try {
    apiInstance.udateGroup(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#udateGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Group**](Group.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/yaml
 - **Accept**: Not defined

<a name="udateStudent"></a>
# **udateStudent**
> udateStudent(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DefaultApi apiInstance = new DefaultApi();
Student body = new Student(); // Student | 
try {
    apiInstance.udateStudent(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#udateStudent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Student**](Student.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/yaml
 - **Accept**: Not defined


# Codeforces API

This is a work-in-progress Java wrapper for the [Codeforces REST API](https://codeforces.com/apiHelp). Currently, the only supported method is `contest.standings`, and anonymous and authorized access are both supported.
To use authorized access, please [create a Codeforces API key and secret](https://codeforces.com/settings/api).

I wrote this API for integration with the Contest Administration, Notifications, and Information System.

## Example usage
```java
String key = "...";
String secret = "...";

CodeforcesApi api = new CodeforcesApi(key, secret);
```

```java
// Group contest: requires authorization
StatusRequestBuilder statusRequestBuilder = api.newStatusRequest();
statusRequestBuilder.setContestId(...).setGroupCode("...");
statusRequestBuilder.setAsManager(true);
statusRequestBuilder.setCount(5);

Request<StatusResult> req = statusRequestBuilder.build();
System.out.println(req.sendRequest());
```

```java
// Public contest
StatusRequestBuilder statusRequestBuilder = api.newStatusRequest();
statusRequestBuilder.setContestId(2000);
statusRequestBuilder.setCount(8);

Request<StatusResult> req = statusRequestBuilder.build();
System.out.println(req.sendRequest());
```

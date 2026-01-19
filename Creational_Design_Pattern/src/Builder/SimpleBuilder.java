package Builder;

/*
The Builder Design Pattern is a creational pattern that lets you construct
complex objects step-by-step, separating the construction logic from the
final representation.
It’s particularly useful in situations where:
     * An object requires many optional fields, and not all of them
      are needed every time.
     * You want to avoid telescoping constructors or large constructors
      with multiple parameters.
     * The object construction process involves multiple steps that need
      to happen in a particular order.

When building such objects, developers often rely on constructors with
many parameters or expose setters for every field. For example,
a User class might have fields like name, email, phone, address,
and preferences.
But as the number of fields grows, this approach becomes hard to manage,
error-prone, and violates the Single Responsibility Principle — mixing
construction logic with business logic.
The Builder Pattern solves this by introducing a separate builder class that
handles the object creation process. The client uses this builder to
construct the object step-by-step, while keeping the final object immutable,
consistent, and easy to create.
*/

/*
A common approach is to use constructor overloading often referred to
as the telescoping constructor anti-pattern. Here you define multiple
constructors with increasing numbers  of parameters:
    1. Hard to Read and Write : Multiple parameters of the same type
    (e.g., String, Map) make it easy to accidentally swap arguments.
    Code is difficult to understand at a glance especially when most
    parameters are null.
    2. Error-Prone : Clients must pass null for optional parameters
    they don’t want to set, increasing the risk of bugs.
    Defensive programming inside constructors becomes necessary to
    avoid NullPointerExceptions.
    3. Poor Scalability : Adding a new optional parameter requires adding
     or changing constructors, which may break existing code or force unnecessary updates to the client.
     Testing and documentation become increasingly difficult to maintain.
*/

/*
IN a builder Pattern :
The construction logic is encapsulated in a Builder.
The final object (the "Product") is created by calling a build() method.
The object itself typically has a private or package-private constructor,
forcing construction through the builder.

Builder : Defines methods to configure or set up product
Return this from each method

Product : final object being constructed
 */

class HttpRequest {
    private final String url;
    private final int timeout;
    private final String body;

    private HttpRequest(Builder builder){
        this.url = builder.url;
        this.timeout = builder.timeout;
        this.body = builder.body;
    }

    public String getUrl() {return url;}
    public int getTimeout() {return timeout;}
    public String getBody() {return body;}

    @Override
    public String toString() {
        return this.url + " "+this.timeout+" "+this.body;
    }

    public static class Builder {
        private String url;
        private int timeout;
        private String body;

        Builder setUrl(String url){
            this.url = url;
            return this;
        }

        Builder setTimeOut(int timeOut){
            this.timeout = timeOut;
            return this;
        }

        Builder setBody(String body){
            this.body = body;
            return this;
        }

        public HttpRequest build(){
            return new HttpRequest(this);
        }
    }

}

public class SimpleBuilder {
    public void main(){
        HttpRequest req = new HttpRequest.Builder().setUrl("google.com")
                .setTimeOut(3000)
                .setBody("Hello World")
                .build();
        HttpRequest req2 = new HttpRequest.Builder().build();
        System.out.println(req.toString());
        System.out.println(req2.toString());
    }
}

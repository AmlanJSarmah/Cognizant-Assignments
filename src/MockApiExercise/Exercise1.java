package MockApiExercise;

class ExternalApi {
    public String getData() {
        return "Real Data";
    }
}

class MyService {
    private ExternalApi api;

    MyService(ExternalApi api) {
        this.api = api;
    }

    String fetchData() {
        return api.getData();
    }
}

public class Exercise1 {
}

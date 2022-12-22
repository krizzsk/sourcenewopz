package didinet;

public interface ApolloAPI {
    public static final ApolloAPI NONE = new ApolloAPI() {
        public Toggle getToggle(String str) {
            return Toggle.NONE;
        }

        public Toggle getToggle(String str, boolean z) {
            return Toggle.NONE;
        }
    };

    public interface Experiment {
        public static final Experiment NONE = new Experiment() {
            public <T> T getParam(String str, T t) {
                return t;
            }

            public String getTestKey() {
                return "";
            }
        };

        <T> T getParam(String str, T t);

        String getTestKey();
    }

    public interface Toggle {
        public static final Toggle NONE = new Toggle() {
            public boolean allow() {
                return false;
            }

            public String getName() {
                return "";
            }

            public Experiment getExperiment() {
                return Experiment.NONE;
            }

            public Integer getLogRate() {
                return 0;
            }
        };

        boolean allow();

        Experiment getExperiment();

        Integer getLogRate();

        String getName();
    }

    Toggle getToggle(String str);

    Toggle getToggle(String str, boolean z);
}

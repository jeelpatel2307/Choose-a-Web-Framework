public class WebFrameworkSelector {
    public static void main(String[] args) {
        WebFrameworkEvaluator evaluator = new WebFrameworkEvaluator();
        evaluator.evaluateFrameworks();
        WebFramework chosenFramework = evaluator.getChosenFramework();
        System.out.println("Based on your requirements, the recommended web framework is: " + chosenFramework.getName());
    }
}

class WebFrameworkEvaluator {
    private List<WebFramework> frameworks;
    private WebFramework chosenFramework;

    public WebFrameworkEvaluator() {
        frameworks = new ArrayList<>();
        frameworks.add(new SpringFramework());
        frameworks.add(new JakartaEEFramework());
        frameworks.add(new PlayFramework());
        frameworks.add(new MicronautFramework());
    }

    public void evaluateFrameworks() {
        int maxScore = 0;
        for (WebFramework framework : frameworks) {
            int score = framework.evaluateFramework();
            if (score > maxScore) {
                maxScore = score;
                chosenFramework = framework;
            }
        }
    }

    public WebFramework getChosenFramework() {
        return chosenFramework;
    }
}

abstract class WebFramework {
    private String name;
    private int scalability;
    private int performance;
    private int community;
    private int documentation;
    private int tooling;

    public WebFramework(String name, int scalability, int performance, int community, int documentation, int tooling) {
        this.name = name;
        this.scalability = scalability;
        this.performance = performance;
        this.community = community;
        this.documentation = documentation;
        this.tooling = tooling;
    }

    public abstract int evaluateFramework();

    public String getName() {
        return name;
    }

    public int getScalability() {
        return scalability;
    }

    public int getPerformance() {
        return performance;
    }

    public int getCommunity() {
        return community;
    }

    public int getDocumentation() {
        return documentation;
    }

    public int getTooling() {
        return tooling;
    }
}

class SpringFramework extends WebFramework {
    public SpringFramework() {
        super("Spring", 5, 4, 5, 5, 5);
    }

    @Override
    public int evaluateFramework() {
        return getScalability() + getPerformance() + getCommunity() + getDocumentation() + getTooling();
    }
}

class JakartaEEFramework extends WebFramework {
    public JakartaEEFramework() {
        super("Jakarta EE", 4, 4, 4, 4, 4);
    }

    @Override
    public int evaluateFramework() {
        return getScalability() + getPerformance() + getCommunity() + getDocumentation() + getTooling();
    }
}

class PlayFramework extends WebFramework {
    public PlayFramework() {
        super("Play", 4, 5, 3, 3, 4);
    }

    @Override
    public int evaluateFramework() {
        return getScalability() + getPerformance() + getCommunity() + getDocumentation() + getTooling();
    }
}

class MicronautFramework extends WebFramework {
    public MicronautFramework() {
        super("Micronaut", 4, 5, 3, 3, 4);
    }

    @Override
    public int evaluateFramework() {
        return getScalability() + getPerformance() + getCommunity() + getDocumentation() + getTooling();
    }
}

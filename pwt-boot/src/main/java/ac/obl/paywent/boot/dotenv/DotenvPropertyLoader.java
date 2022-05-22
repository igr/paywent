package ac.obl.paywent.boot.dotenv;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvPropertyLoader {

    private final Dotenv dotenv;

    public DotenvPropertyLoader() {
        dotenv = Dotenv.configure()
            .directory(System.getProperty("user.dir"))
            .ignoreIfMissing()
            .load();
    }

    public Object getValue(final String key) {
        return dotenv.get(key);
    }
}

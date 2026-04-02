import com.intuit.karate.junit5.Karate;

class SampleRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run("sample").relativeTo(getClass());
    }
}

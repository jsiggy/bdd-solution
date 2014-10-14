package acceptance.util;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CasePreservingResolver;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public abstract class JBehaveStoryRunner extends JUnitStory {

   protected JBehaveStoryRunner() {
      String[] metaFilters = {"-skip"};
      Embedder embedder = configuredEmbedder();
      embedder.useMetaFilters(Arrays.asList(metaFilters));
      embedder.embedderControls()
         .doGenerateViewAfterStories(true)
         .doIgnoreFailureInView(true);
      System.setProperty("instance.name", "localhost");
   }

   @Override
   public Configuration configuration() {
      return new MostUsefulConfiguration()
         .useStoryPathResolver(new CasePreservingResolver())
         .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
         .useStoryReporterBuilder(
            new StoryReporterBuilder()
               .withDefaultFormats()
               .withFormats(Format.HTML, Format.CONSOLE)
         );
   }

   @Override
   public List<CandidateSteps> candidateSteps() {
      return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
   }
}

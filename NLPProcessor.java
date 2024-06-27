import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class NLPProcessor {
    private StanfordCoreNLP pipeline;

    public NLPProcessor() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");
        this.pipeline = new StanfordCoreNLP(props);
    }

    public String process(String text) {
        CoreDocument document = new CoreDocument(text);
        pipeline.annotate(document);
        for (CoreMap sentence : document.sentences()) {
            // Process the sentence
        }
        return text;
    }
}

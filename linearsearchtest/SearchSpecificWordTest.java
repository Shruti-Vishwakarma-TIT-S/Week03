package linearsearchtest;
import com.java.linearsearch.SearchSpecificWord;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class SearchSpecificWordTest {
    @Test
    public void findSentence(){
        String[] sentences = {"Lily is a flower.",
        "It is found on the land as well as into the water.",
        "Lily has different colors."};
        String word = SearchSpecificWord.findSentenceWithWord(sentences, "Lily");
        Assert.assertEquals("Lily is a flower.", word);
    }

    @Test
    public void findSentence2(){
        String[] sentences = {"My day was good.",
        "I enjoyed a lot.",
        "I learnt new things today.",
        "Currently, I am learning to perform unit testing."};
        String word = SearchSpecificWord.findSentenceWithWord(sentences, "I");
        Assert.assertEquals("I enjoyed a lot.", word);

    }

}

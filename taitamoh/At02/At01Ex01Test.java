package taitamoh.At02;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import taitamoh.At01.At01Ex01;
public class At01Ex01Test {
    @Test
    void pareil3V01(){
assertEquals(3, At01Ex01.moyenne(3, 3, 3));
    }
    @Test
    void diff3V02(){
        final float DELTA=0.00001f;
        assertEquals(5, At01Ex01.moyenne(3, 5, 7), DELTA,"Moyenne Valide");
    }
}

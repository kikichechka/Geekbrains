package geekbrains.lesson;

import com.geekbrains.Lesson14;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MyTest {
Lesson14 lesson14 = new Lesson14();

    @Test
    public void test1CutOff() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 7, 9, 0));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 7, 6, 4, 2, 5, 7, 9, 0));
        Assert.assertEquals(list, Lesson14.cutOff(list1));
    }
    @Test
    public void test2CutOff() {
        List<Integer> list = new ArrayList<>(Arrays.asList(15, 7));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 10, 13, 99, 66, 4, 15, 7));
        Assert.assertEquals(list, Lesson14.cutOff(list1));
    }
    @Test
    public void test3CutOff() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 12));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(33, 6, 7, 11, 8, 4, 12));
        Assert.assertEquals(list, Lesson14.cutOff(list1));
    }

    @Test
    public void test1Examination() {
        Assert.assertTrue(Lesson14.examination(new int[] {1, 1, 1, 1, 1}));
    }
    @Test
    public void test2Examination() {
        Assert.assertFalse(Lesson14.examination(new int[] {1, 1, 1, 1, 1}));
    }
    @Test
    public void test3Examination() {
        Assert.assertFalse(Lesson14.examination(new int[] {1, 1, 1, 4, 4, 1, 4, 1}));
    }
    @Test
    public void test4Examination() {
        Assert.assertTrue(Lesson14.examination(new int[] {1, 1, 1, 4, 4, 1, 4, 1}));
    }
}


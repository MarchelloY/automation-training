import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    //Равносторонний треугольник (1)
    @Test
    public void equilateralTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(1, 1, 1));
    }

    //Прямоугольный треугольник (2)
    @Test
    public void rightTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(5, 3, 4));
    }

    //Разносторонний, существующий треугольник (3)
    @Test
    public void versatileExistTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(5, 3, 6));
    }

    //Разносторонний, не существующий треугольник (4)
    @Test
    public void versatileNoExistTriangle() {
        Assert.assertFalse(Triangle.isTriangleExist(5, 3, 2));
    }

    //Треугольник с отрицательной стороной (5)
    @Test
    public void negativeSideTriangle() {
        Assert.assertFalse(Triangle.isTriangleExist(-2, 3, 1));
    }

    //Треугольник с нулевой стороной (6)
    @Test
    public void zeroSideTriangle() {
        Assert.assertFalse(Triangle.isTriangleExist(0, 3, 1));
    }

    //Равнобедренный, существующий треугольник (7)
    @Test
    public void isoscelesExistTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(2, 3, 3));
    }

    //Равнобедренный, не существующий треугольник (8)
    @Test
    public void isoscelesNoExistTriangle() {
        Assert.assertFalse(Triangle.isTriangleExist(2, 1, 1));
    }

    //Треугольник с нулевыми сторонами (9)
    @Test
    public void allZeroSidesTriangle() {
        Assert.assertFalse(Triangle.isTriangleExist(0, 0, 0));
    }

    //Треугольник с отрицательными сторонами (10)
    @Test
    public void allNegativeSidesTriangle() {
        Assert.assertFalse(Triangle.isTriangleExist(-1, -2, -3));
    }
}

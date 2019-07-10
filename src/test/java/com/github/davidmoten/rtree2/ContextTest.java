package com.github.davidmoten.rtree2;

import org.junit.Test;

import com.github.davidmoten.rtree2.Context;
import com.github.davidmoten.rtree2.Factories;
import com.github.davidmoten.rtree2.SelectorMinimalAreaIncrease;
import com.github.davidmoten.rtree2.SplitterQuadratic;
import com.github.davidmoten.rtree2.geometry.Geometry;

public class ContextTest {

    @Test(expected = RuntimeException.class)
    public void testContextIllegalMinChildren() {
        new Context<Object, Geometry>(0, 4, new SelectorMinimalAreaIncrease(),
                new SplitterQuadratic(), Factories.defaultFactory());
    }

    @Test(expected = RuntimeException.class)
    public void testContextIllegalMaxChildren() {
        new Context<Object, Geometry>(1, 2, new SelectorMinimalAreaIncrease(),
                new SplitterQuadratic(), Factories.defaultFactory());
    }

    @Test(expected = RuntimeException.class)
    public void testContextIllegalMinMaxChildren() {
        new Context<Object, Geometry>(4, 3, new SelectorMinimalAreaIncrease(),
                new SplitterQuadratic(), Factories.defaultFactory());
    }

    @Test
    public void testContextLegalChildren() {
        new Context<Object, Geometry>(2, 4, new SelectorMinimalAreaIncrease(),
                new SplitterQuadratic(), Factories.defaultFactory());
    }

    @Test(expected = NullPointerException.class)
    public void testContextSelectorNullThrowsNPE() {
        new Context<Object, Geometry>(2, 4, null, new SplitterQuadratic(),
                Factories.defaultFactory());
    }

    @Test(expected = NullPointerException.class)
    public void testContextSplitterNullThrowsNPE() {
        new Context<Object, Geometry>(2, 4, new SelectorMinimalAreaIncrease(), null,
                Factories.defaultFactory());
    }

    @Test(expected = NullPointerException.class)
    public void testContextNodeFactoryNullThrowsNPE() {
        new Context<Object, Geometry>(2, 4, new SelectorMinimalAreaIncrease(),
                new SplitterQuadratic(), null);
    }
}

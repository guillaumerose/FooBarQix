package net.grose.foo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FooBarQixTest {
    @Test public void
    returns_itself() {
        verify("1", 1);
        verify("2", 2);
        verify("4", 4);
        verify("8", 8);
    }
    
    @Test public void
    divisor_of_three() {
        verify("FooFoo", 3);
        verify("Foo", 6);
        verify("Foo", 9);
    }
    
    @Test public void
    divisor_of_five() {
        verify("BarBar", 5);
        verify("Bar", 10);
        verify("FooBar", 15);
    }
    
    @Test public void
    divisor_of_seven() {
        verify("QixQix", 7);
        verify("Qix", 14);
        verify("FooQix", 21);
    }

    private void verify(String expected, int row) {
        assertThat(FooBarQix.eval(row), is(expected));
    }
}

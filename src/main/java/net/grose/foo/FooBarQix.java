package net.grose.foo;

import static com.google.common.base.Predicates.notNull;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Maps.filterKeys;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;

public class FooBarQix {
    private static final Map<Integer, String> ASSOC = ImmutableMap.of(3, "Foo", 
                                                                      5, "Bar",
                                                                      7, "Qix");
    
    public static String eval(final Integer i) {
        List<String> symbols = newArrayList(filterKeys(ASSOC, divisorOf(i)).values());
        symbols.addAll(filter(transform(lettersOf(i), TO_SYMBOL), notNull()));
        
        return symbols.isEmpty() ? String.valueOf(i) : Joiner.on("").join(symbols);
    }

    private static Predicate<Integer> divisorOf(final Integer i) {
        return new Predicate<Integer>() {
            @Override public boolean apply(Integer input) {
                return i % input == 0;
            }
        };
    }

    private static List<String> lettersOf(final Integer i) {
        return asList(String.valueOf(i).split("", 1));
    }

    private static Function<String, String> TO_SYMBOL = new Function<String, String>() {
        @Override public String apply(String input) {
            return ASSOC.get(Integer.valueOf(input));
        }
    };
}

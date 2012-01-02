require "test/unit"

require "../lib/foo"

class TestFoo < Test::Unit::TestCase
  def test_retourne_la_meme_chose
    verify("1", 1)
    verify("2", 2)
    verify("4", 4)
    verify("8", 8)
  end

  def test_divisible_par_trois
    verify("FooFoo", 3)
    verify("Foo", 6)
    verify("Foo", 9)
  end

  def test_divisible_par_cinq
    verify("BarBar", 5)
    verify("Bar", 10)
    verify("FooBarBar", 15)
  end

  def test_divisible_par_sept
    verify("QixQix", 7)
    verify("Qix", 14)
    verify("FooQix", 21)
  end

  def test_avec_clarifications
    verify("FooBar", 51)
    verify("BarFoo", 53)
    verify("FooFooFoo", 33)
  end

  def verify(expected, row)
    assert_equal(expected, Foo.eval(row))
  end
end
class Foo
  EQ = {
    3 => "Foo",
    5 => "Bar",
    7 => "Qix"
  }

  def self.eval(i)
    retour = divisible_ou_contient_un_chiffre(i)
    retour != "" ? retour : i.to_s
  end

  def self.divisible_ou_contient_un_chiffre(i)
    listes_des_diviseurs(i).join("") \
    + lettres(i).map { |lettre| symbol_equivalent(lettre) }.join("")
  end

  def self.listes_des_diviseurs(i)
    EQ.select { |k| i % k == 0 }.values
  end

  def self.lettres(i)
    i.to_s.split("")
  end

  def self.symbol_equivalent(lettre)
    EQ[lettre.to_i]
  end
end
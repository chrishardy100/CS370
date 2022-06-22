public class Weapon {

  protected int damage;
  protected String color;
  protected String name;
  
  public int getDamage(){
    return this.damage;
  }
  public class Builder {
    Weapon weapon = new Weapon();-
    
  
    public Builder SetDamage(int damage){
      weapon.damage = damage;
      return this;
  
    }
    public Builder setName(String name){
      weapon.name = name;
      return this;
    }
    public Builder setColor(String color){
      weapon.color = color;
      return this;
    }
    public Builder setDecorator(WeaponDecorator decor){
      weapon = decor(new Weapon());


    }
    public Weapon build(){
      return weapon;
    }
    
  }
}

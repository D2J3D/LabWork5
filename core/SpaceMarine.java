package Server.core;


import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

/**
 *  SpaceMarine - главная сущность, используемая в программе
 */
public class SpaceMarine implements Comparable<SpaceMarine>, Serializable {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    /**
     * Значение поля health не может быть меньше 0
     */
    private float health;
    /**
     * поле AstartesCategory не может быть null
     */
    private AstartesCategory astartesCategory;
    /**
     * поле Weapon не может быть null
     */
    private Weapon weaponType;
    /**
     * поле MeleeWeapon не может быть null
     */
    private MeleeWeapon meleeWeapon;
    /**
     * поле Chapter не может быть null
     */
    private Chapter chapter;

    public SpaceMarine(float health, String name){
        this.health = health;
        this.name = name;
        this.creationDate = ZonedDateTime.now();
    }
    public SpaceMarine(String name, Coordinates coordinates, float health, AstartesCategory astartesCategory, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter){
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.astartesCategory = astartesCategory;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
        this.creationDate = ZonedDateTime.now();
        Random random = new Random(new Date().getTime());
        this.id = random.nextInt();
    }


    public void setCategory(AstartesCategory category) {
        this.astartesCategory = category;
    }

    public SpaceMarine(){
        this.id = 1;
        this.creationDate = ZonedDateTime.now();
    }

    public String getName() {
        return this.name;
    }

    public AstartesCategory getAstartesCategory(){
        return astartesCategory;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public float getHealth() {
        return health;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }



    public Weapon getWeaponType() {
        return weaponType;
    }

    public Integer getId() {
        return id;
    }

    public void setAstartesCategory(AstartesCategory category) {
        this.astartesCategory = category;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }



    public void setHealth(float health) {
        this.health = health;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        //return this.name + ", " + this.health + ", " + this.creationDate;

         return "Soldier " + this.name + " " + this.health + "HP " + this.id + "-ID\n" + "Chapter: " + this.chapter.getName() + "\nAstartes category " + this.astartesCategory +
                  "\nWeapon: " + this.weaponType + "\nMelee weapon " + this.meleeWeapon +
                 "\nCoordinates (x,y) = " + this.coordinates.getX() + "," + this.coordinates.getY() +
                 "\nCreation date: " + this.creationDate + "\n";


    }

    @Override
    public int compareTo(SpaceMarine s){

        //if ((this.category == s.category) && (this.weaponType == s.weaponType) && (this.meleeWeapon == s.meleeWeapon)){
          //  return 0;
        //}
        if (this.health == s.health){
            return 0;
        }
        if (this.health > s.health){
            return 1;
        }
        return -1;
    }

}

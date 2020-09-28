public class Animal {
    private String species;
    private char gender;
    private int age;

    public Animal(String species) {
        this.species = species;
    }

    public Animal(String species, char sexual) {
        this.species = species;
        this.gender = sexual;
    }

    public Animal(String species, char sexual, int age) {
        this.species = species;
        this.gender = sexual;
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(char sexual) {
        this.gender = sexual;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(String species){
        return this.species.equals(species)?true:false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}

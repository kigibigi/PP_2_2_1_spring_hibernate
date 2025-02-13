package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@IdClass(SeriesPK.class)
public class Car {

    private String model;

    @Id
    @Column(unique = true)
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    @OneToOne(mappedBy = "userCar")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
               "series=" + series + '\''+
               ", model='" + model  +
               '}';
    }
}

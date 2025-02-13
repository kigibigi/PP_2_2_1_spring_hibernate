package hiber.model;

import java.io.Serializable;
import java.util.Objects;

public class SeriesPK implements Serializable {
    private int series;

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SeriesPK seriesPK = (SeriesPK) object;
        return series == seriesPK.series;
    }

    @Override
    public int hashCode() {
        return Objects.hash(series);
    }
}

package br.edu.uniritter.topi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@EqualsAndHashCode @ToString
@Getter
@Setter
public class Event {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Event setDate(Date date) {
        this.date = date;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
}
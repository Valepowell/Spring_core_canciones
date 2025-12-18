package com.valeskapowell.modelos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artista_id")
    private Artista artista;
    
    @NotBlank(message = "El álbum es obligatorio")
    @Size(min = 3, message = "El nombre del álbum debe tener al menos 3 caracteres")
    private String album;
    
    @NotBlank(message = "El género es obligatorio")
    @Size(min = 3, message = "El género debe tener al menos 3 caracteres")
    private String genero;
    
    @NotBlank(message = "El idioma es obligatorio")
    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres")
    private String idioma;

	@CreationTimestamp
	@Column(name= "fecha_creacion", updatable=false)
	private LocalDateTime fechaCreacion;
	
	@UpdateTimestamp
	@Column(name= "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

    public Cancion() {}

        @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Artista getArtista() { return artista;}
    public void setArtista(Artista artista) { this.artista = artista;}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }


}
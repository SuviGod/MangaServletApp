package ua.sulima.mangaservletapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "manga_name")
    private String mangaName;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "release_year")
    private Short releaseYear;

    @Column(name = "translator_id")
    private Long translatorId;

    @Column(name = "alternative_manga_name")
    private String alternativeMangaName;

    @Column(name = "add_datetime", insertable = false)
    private Timestamp addDatetime;

    @Column(name = "update_datetime", insertable = false)
    private Timestamp updateDatetime;

    @Column(name = "approval_datetime", insertable = false)
    private Timestamp approvalDatetime;

    @Column(name = "preview_image_path")
    private String previewImagePath;

    @Column(name = "is_approved", insertable = false)
    private Boolean isApproved;

}

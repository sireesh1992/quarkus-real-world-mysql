package org.example.realworldapi.infrastructure.repository.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.realworldapi.domain.model.tag.Tag;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TAGS")
public class TagEntity {

  @Type(type="uuid-char")
  @Id private UUID id;

  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  private List<TagRelationshipEntity> articlesTags;

  public TagEntity(Tag tag) {
    this.id = tag.getId();
    this.name = tag.getName();
  }
}

package dao;

import java.util.List;
import java.util.UUID;

import dto.Tag;

public interface ITagDAO {
	
	public void addTags(final Tag tag);

	public List<Tag> getTags();

	public Tag getTagById(UUID idTag);
}

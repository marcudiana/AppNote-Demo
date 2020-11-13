package bussines;

import java.util.List;
import java.util.UUID;

import dto.Tag;

public interface ITagBussines {
	
	public void addTag(final Tag tag) throws Exception;
	public List<Tag> getTags();
	public Tag getTagById(UUID idTag);
	
}

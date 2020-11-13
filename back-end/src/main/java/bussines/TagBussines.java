package bussines;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ITagDAO;
import dto.Tag;

@Stateless
public class TagBussines implements ITagBussines {
	
	@EJB
	ITagDAO tagDAO;

	@Override
	public void addTag(Tag tag) throws Exception {
		// TODO Auto-generated method stub
		this.tagDAO.addTags(tag);
	}

	@Override
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		return this.tagDAO.getTags();
	}

	@Override
	public Tag getTagById(UUID idTag) {
		// TODO Auto-generated method stub
		return this.tagDAO.getTagById(idTag);
	}
}

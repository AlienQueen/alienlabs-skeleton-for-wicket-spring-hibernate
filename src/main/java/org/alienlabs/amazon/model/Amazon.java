package org.alienlabs.amazon.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Amazon")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Amazon implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String pictureFilename, amazonName, pictureTitle, pictureDescription, publisherName;

	private String[] metadata;

	private Long numberOfPluses, numberOfMinuses, numberOfVotes;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long amazonId;

	public Amazon()
	{
	}

	public Amazon(final String _pictureFilename, final String _amazonName,
			final String _pictureTitle, final String _pictureDescription,
			final String _publisherName, final String[] _metadata, final Long _numberOfPluses,
			final Long _numberOfMinuses, final Long _numberOfVotes)
	{
		this.pictureFilename = _pictureFilename;
		this.amazonName = _amazonName;
		this.pictureTitle = _pictureTitle;
		this.pictureDescription = _pictureDescription;
		this.publisherName = _publisherName;
		this.metadata = _metadata;
		this.numberOfPluses = _numberOfPluses;
		this.numberOfMinuses = _numberOfMinuses;
		this.numberOfVotes = _numberOfVotes;
	}

	public Long getAmazonId()
	{
		return this.amazonId;
	}

	public void setAmazonId(final Long _amazonId)
	{
		this.amazonId = _amazonId;
	}

	public String getAmazonName()
	{
		return this.pictureFilename;
	}

	public void setAmazonName(final String _amazonName)
	{
		this.pictureFilename = _amazonName;
	}

	public String getPictureTitle()
	{
		return this.pictureTitle;
	}

	public void setPictureTitle(final String _pictureTitle)
	{
		this.pictureTitle = _pictureTitle;
	}

	public String getPictureFilename()
	{
		return this.pictureFilename;
	}

	public void setPictureFilename(final String _pictureFilename)
	{
		this.pictureFilename = _pictureFilename;
	}

	public void setPictureName(final String _pictureTitle)
	{
		this.pictureTitle = _pictureTitle;
	}

	public String getPictureDescription()
	{
		return this.pictureDescription;
	}

	public void setPictureDescription(final String _pictureDescription)
	{
		this.pictureDescription = _pictureDescription;
	}

	public String getPublisherName()
	{
		return this.publisherName;
	}

	public void setPublisherName(final String _publisherName)
	{
		this.publisherName = _publisherName;
	}

	public String[] getMetadata()
	{
		return this.metadata;
	}

	public void setMetadata(final String[] _metadata)
	{
		this.metadata = _metadata;
	}

	public Long getNumberOfPluses()
	{
		return this.numberOfPluses;
	}

	public void setNumberOfPluses(final Long _numberOfPluses)
	{
		this.numberOfPluses = _numberOfPluses;
	}

	public Long getNumberOfMinuses()
	{
		return this.numberOfMinuses;
	}

	public void setNumberOfMinuses(final Long _numberOfMinuses)
	{
		this.numberOfMinuses = _numberOfMinuses;
	}

	public Long getNumberOfVotes()
	{
		return this.numberOfVotes;
	}

	public void setNumberOfVotes(final Long _numberOfVotes)
	{
		this.numberOfVotes = _numberOfVotes;
	}

}

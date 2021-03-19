import datetime

from flask import current_app
from sqlalchemy.sql import func

from . import db


class Project(db.Model):
    
    __tablename__ = 'projects'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    title = db.Column(db.String(255), nullable=False)
    text = db.Column(db.String(4000), nullable=False)
    created_at = db.Column(db.DateTime(timezone=True), server_default=func.now())

    def __init__(self, title, text, created_at):
        self.title = title
        self.text = text

    def json(self):
        return { 'title': self.title, 'text': self.text, 'created_at': self.created_at }

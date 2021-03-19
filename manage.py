from flask.cli import FlaskGroup

from src import create_app, db
from src.models import Project


app = create_app()
cli = FlaskGroup(create_app=create_app)


@cli.command('recreate_db')
def recreate_db():
    db.drop_all()
    db.create_all()
    db.session.commit()


@cli.command('seed_db')
def seed_db():
    """Seeds the database."""
    db.session.add(Project(
        title='Database',
        text='Containerized PostgresSQL Database which talks to Flask API, gives information when requested.'
    ))
    
    db.session.add(Project(
        title='API',
        text='Containerized API, that talks with the postgresql database in order to fetch data. That data gets sent once the frontend send a request to the API. Made with Flask, SQLAlchemy (in Python).'
    ))
        
    db.session.add(Project(
        title='Frontend',
        text='Containerized Frontend, sends requests to the Flask API when in need of data, does not have any direct contact with the Database at all, Made with React.js in Javascript.'
    ))
    
    db.session.commit()


if __name__ == '__main__':
    cli()

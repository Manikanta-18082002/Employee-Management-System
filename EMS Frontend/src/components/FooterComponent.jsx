// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';

const FooterComponent = () => {
  const [currentYear, setCurrentYear] = useState(new Date().getFullYear());

  useEffect(() => {
    setCurrentYear(new Date().getFullYear());
  }, []);

  return (
    <div>
      <footer className='footer'>
        <span>All rights reserved {currentYear} by ManiKanta</span>
      </footer>
    </div>
  );
}

export default FooterComponent;
